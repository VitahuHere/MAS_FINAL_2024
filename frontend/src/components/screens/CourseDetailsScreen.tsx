import CourseSettings from "../CourseSettings.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link, useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { fetchCourseDetails } from "../../services/CourseService.ts";
import { Student } from "../../types/StudentType.ts";
import { Tutorial, TutorialDTO } from "../../types/TutorialType.ts";
import { Task } from "../../types/TaskType.ts";
import { Opinion } from "../../types/OpinionType.ts";

const studentHeaders = [
  {
    name: "Login",
    align: "left",
  },
  {
    name: "Full name",
    align: "center",
  },
];

const tutorialHeaders = [
  {
    name: "Number",
    align: "left",
  },
  {
    name: "Type",
    align: "center",
  },
  {
    name: "Details",
    align: "left",
  },
];

const taskHeaders = [
  {
    name: "ID",
    align: "left",
  },
  {
    name: "Title",
    align: "center",
  },
  {
    name: "Status",
    align: "right",
  },
];

const opinionHeaders = [
  {
    name: "Score",
    align: "left",
  },
  {
    name: "Comment",
    align: "center",
  },
];

export default function CourseDetailsScreen() {
  const [studentData, setStudentData] = useState<Student[]>([]);
  const [tutorialData, setTutorialData] = useState<Tutorial[]>([]);
  const [taskData, setTaskData] = useState<Task[]>([]);
  const [opinionData, setOpinionData] = useState<Opinion[]>([]);
  const [taskName, setTaskName] = useState("");
  const [taskID, setTaskID] = useState(0);
  let { id } = useParams();
  const navigate = useNavigate();
  useEffect(() => {
    fetchCourseDetails(Number(id)).then((data) => {
      if (!data) {
        return navigate("/course-not-found");
      }
      setTaskName(data.name);
      setTaskID(data.id);
      setStudentData(data.students);
      const newTutorialData: Tutorial[] = [];
      for (let i = 0; i < data.tutorials.length; i++) {
        const tutorial: TutorialDTO = data.tutorials[i];
        newTutorialData.push({
          number: i + 1,
          type: tutorial.type,
          details: tutorial.details,
        });
      }
      setTutorialData(newTutorialData);
      setTaskData(data.tasks);
      setOpinionData(data.opinions);
    });
  }, []);

  return (
    <div className="flex flex-col h-full items-center">
      <div className="relative flex items-center w-full">
        <div className="flex flex-row items-center z-10">
          <Link to={"/"}>
            <img
              src="/rubber-duck.png"
              alt="Rubber Duck"
              className="w-[178px]"
            />
          </Link>
        </div>
        <div className="absolute inset-0 flex justify-center items-center">
          <h1 className="text-8xl">{taskName}</h1>
        </div>
      </div>
      <div className="w-full flex justify-center">Public ID: {taskID}</div>
      <div className="flex flex-row w-full h-full space-x-10 mt-10">
        <div className="flex flex-col space-y-10">
          <CourseSettings />
          <ListContainer
            title={"Students"}
            headers={studentHeaders}
            data={studentData}
          />
        </div>
        <div className="w-3/5">
          <ListContainer
            title={"Tutorials"}
            headers={tutorialHeaders}
            data={tutorialData}
          />
        </div>
        <div className="flex flex-col w-3/5 space-y-5">
          <ListContainer
            title={"Course tasks"}
            headers={taskHeaders}
            data={taskData}
            addNew={
              <div className="flex justify-center mt-5">
                <Link to="/notimplemented">+ Add new course</Link>
              </div>
            }
          />
          <ListContainer
            title={"Course opinions"}
            headers={opinionHeaders}
            data={opinionData}
          />
        </div>
      </div>
    </div>
  );
}
