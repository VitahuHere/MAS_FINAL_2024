import Navbar from "../Navbar.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link } from "react-router-dom";

const courses = [
  {
    name: "Java 101",
    description: "Learn Java from zero to hero",
    createdAt: "2024-01-01",
    updatedAt: "2024-04-16",
  },
  {
    name: "Python 101",
    description: "Learn Python from zero to true master",
    createdAt: "2023-11-12",
    updatedAt: "2024-02-22",
  },
  {
    name: "Python master course",
    description: "Python for experienced users",
    createdAt: "2023-10-11",
    updatedAt: "2024-01-22",
  },
];

const headers = [
  { name: "Course name", align: "left", width: "fit-content" },
  { name: "Description", align: "center", width: "auto" },
  { name: "Created at", align: "right", width: "fit-content" },
  { name: "Updated at", align: "right", width: "fit-content" },
];

export default function CourseManageScreen() {
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
              <Link to="/courses/add/">+ Add new course</Link>
            </div>
          }
        />
      </div>
    </div>
  );
}
