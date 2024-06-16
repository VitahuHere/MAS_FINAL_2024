import { Link } from "react-router-dom";

export default function Shortcuts() {
  return (
    <div className="flex flex-col mt-28 ml-28">
      <h1 className="text-8xl">Shortcuts</h1>
      <Link to={"/courses-add-task/"} className="mt-20 text-3xl">
        Add new task to course
      </Link>
      <Link to={"/courses/"} className="text-3xl mt-8">
        Manage courses
      </Link>
    </div>
  );
}
