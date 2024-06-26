import Navbar from "../Navbar.tsx";
import ListContainer from "../ListContainer.tsx";
import { Link, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getTasks } from "../../services/TaskService.ts";

const headers = [
  { name: "ID", align: "left", width: "5%" },
  { name: "Title", align: "center", width: "auto" },
  { name: "Status", align: "right", width: "15%" },
];

export default function TaskManagementScreen() {
  const [tasks, setTasks] = useState([]);
  const { id } = useParams();
  useEffect(() => {
    getTasks(Number(id)).then((data) => {
      setTasks(data);
    });
  }, []);

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
