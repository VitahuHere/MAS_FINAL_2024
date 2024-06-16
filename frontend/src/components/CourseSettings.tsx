import { useNavigate } from "react-router-dom";

export default function CourseSettings() {
  const navigate = useNavigate();

  function handleClick() {
    navigate("/notimplemented");
  }
  return (
    <div className="flex flex-col w-80">
      <h2 className="text-4xl">Course settings</h2>
      <button
        className="bg-[#C09934] rounded-lg mt-5 h-10"
        onClick={handleClick}
      >
        Rename course
      </button>
      <button
        className="bg-[#C09934] mt-4 rounded-lg h-10"
        onClick={handleClick}
      >
        Change description
      </button>
      <button
        className="bg-[#C09934] mt-4 rounded-lg h-10"
        onClick={handleClick}
      >
        Change keywords
      </button>
    </div>
  );
}
