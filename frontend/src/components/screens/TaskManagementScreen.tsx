import Navbar from "../Navbar.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link } from "react-router-dom";

const tasks = [
  {
    id: 1,
    title: "Task 1",
    status: "Done",
  },
  {
    id: 2,
    title: "Task 2",
    status: "In progress",
  },
  {
    id: 3,
    title: "Task 3",
    status: "To do",
  },
];

const headers = [
  { name: "ID", align: "left", width: "5%" },
  { name: "Title", align: "center", width: "auto" },
  { name: "Status", align: "right", width: "15%" },
];

export default function TaskManagementScreen() {
  return (
    <div className="flex flex-col h-full items-center">
      <Navbar title={"Java 101"} />
      <div className="w-full flex justify-center mb-10">Public ID: 00001</div>
      <div className="w-3/5">
        <ListContainer
          title={"Your tasks"}
          headers={headers}
          data={tasks}
          addNew={
            <div className="flex justify-center mt-5">
              <Link to="add/">+ Add new task</Link>
            </div>
          }
        />
      </div>
    </div>
  );
}
