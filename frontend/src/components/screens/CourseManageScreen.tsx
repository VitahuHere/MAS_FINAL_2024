import Navbar from "../Navbar.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { fetchCourses } from "../../services/CourseService.ts";
import { Course } from "../../types/CourseType.ts";

const headers = [
  { name: "Course name", align: "left", width: "fit-content" },
  { name: "Description", align: "center", width: "auto" },
  { name: "Created at", align: "right", width: "fit-content" },
  { name: "Updated at", align: "right", width: "fit-content" },
];

export default function CourseManageScreen({ addTask }: { addTask?: boolean }) {
  const [courses, setCourses] = useState<Course[]>([]);
  const [paths, setPaths] = useState<string[]>([]);

  useEffect(() => {
    fetchCourses().then((response) => {
      const courses = response.map((course) => {
        return {
          name: course.name,
          description: course.description,
          createdAt: course.createdAt,
          updatedAt: course.updatedAt,
        };
      });
      setCourses(courses);
      const paths = response.map((course) => {
        return addTask
          ? `/courses/${course.id}/tasks/add`
          : `/courses/${course.id}`;
      });
      setPaths(paths);
    });
  }, []);

  return (
    <div className="flex flex-col h-full space-y-10 items-center">
      <Navbar title={"Choose your course"} />
      <div className="w-3/5">
        <ListContainer
          title={"Your courses"}
          headers={headers}
          data={courses}
          addNew={
            <div className="flex justify-center mt-5">
              <Link to="/notimplemented">+ Add new course</Link>
            </div>
          }
          redirectPaths={paths}
        />
      </div>
    </div>
  );
}
