import CourseSettings from "../CourseSettings.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link } from "react-router-dom";

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

const studentData = [
  {
    login: "marks1",
    fullName: "Marks Engel",
  },
  {
    login: "jp2omg",
    fullName: "Jean Pavlo",
  },
];

const tutorialData = [
  {
    number: 1,
    type: "Text",
    details: "In this tutorial we will cover some of the most important",
  },
  {
    number: 2,
    type: "Video",
    details: "https://edukaczka.com/video/123",
  },
  {
    number: 3,
    type: "Text+Video",
    details: "Here are some key moments that will help you understa",
  },
  {
    number: 4,
    type: "Text",
    details: "Hopefully you get the grasp of OOP now. Let’s move on",
  },
];

const taskData = [
  {
    id: 123,
    title: "for loops",
    status: "PUBLISHED",
  },
  {
    id: 124,
    title: "for loops - before while",
    status: "ARCHIVED",
  },
  {
    id: 125,
    title: "while loops",
    status: "DRAFT",
  },
];

const opinionData = [
  {
    score: 5,
    comment: "Excellent course!",
  },
  {
    score: 4,
    comment: "Informative but misleading in places",
  },
  {
    score: 5,
    comment: "Best on the web.",
  },
];

export default function CourseDetailsScreen() {
  return (
    <div className="flex flex-col h-full items-center">
      <div className="relative flex items-center w-full">
        <div className="flex flex-row items-center">
          <img src="/rubber-duck.png" alt="Rubber Duck" className="w-[178px]" />
        </div>
        <div className="absolute inset-0 flex justify-center items-center">
          <h1 className="text-8xl">Java 101</h1>
        </div>
      </div>
      <div className="w-full flex justify-center">Public ID: 00001</div>
      <div className="flex flex-row w-full h-full space-x-10">
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
        <div className="flex flex-col w-3/5 space-y-10">
          <ListContainer
            title={"Course tasks"}
            headers={taskHeaders}
            data={taskData}
            addNew={
              <div className="flex justify-center mt-5">
                <Link to="/courses/add/">+ Add new course</Link>
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
