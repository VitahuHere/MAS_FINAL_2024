import { useState, useEffect, useRef } from "react";
import { Link, useNavigate } from "react-router-dom";
import ListContainer from "../ListContainer.tsx";

const headers = [
  { name: "No.", align: "left", width: "5%" },
  { name: "Answer", align: "center", width: "auto" },
];

export default function AddTaskScreen() {
  const navigate = useNavigate();
  const [title, setTitle] = useState("Task title");
  const [isEditing, setIsEditing] = useState(false);
  const inputRef = useRef<HTMLInputElement>(null);

  function handleTitleChange(event: any) {
    setTitle(event.target.value);
  }

  function handleEdit() {
    setIsEditing(true);
    setTimeout(() => {
      if (inputRef.current) {
        inputRef.current.focus();
      }
    }, 0);
  }

  useEffect(() => {
    function handleClickOutside(event: MouseEvent) {
      if (
        inputRef.current &&
        !inputRef.current.contains(event.target as Node)
      ) {
        setIsEditing(false);
      }
    }

    if (isEditing) {
      document.addEventListener("mousedown", handleClickOutside);
    } else {
      document.removeEventListener("mousedown", handleClickOutside);
    }

    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [isEditing]);

  return (
    <div className="flex flex-col h-full w-full">
      <div className="relative flex items-center w-full">
        <div className="flex flex-row items-center">
          <img src="/rubber-duck.png" alt="Rubber Duck" className="w-[178px]" />
          <button onClick={() => navigate(-1)} className="w-24 h-24">
            <img src="/left-arrow.png" alt="Left Arrow" />
          </button>
        </div>
        <div className="absolute inset-0 flex justify-center items-center">
          {isEditing ? (
            <input
              ref={inputRef}
              className="text-6xl bg-transparent outline-0 max-w-[80%] text-center"
              value={title}
              onChange={handleTitleChange}
            />
          ) : (
            <h1 className="text-6xl">{title}</h1>
          )}
          <button onClick={handleEdit}>
            {!isEditing && (
              <img
                src="/edit-icon.png"
                alt="Edit Icon"
                className="w-10 h-10 ml-4"
              />
            )}
          </button>
        </div>
      </div>
      <div className="flex flex-row h-ful w-full justify-between mt-40">
        <div className="flex flex-col w-80">
          <h2 className="text-4xl">Task settings</h2>
          <button className="bg-[#C09934] rounded-lg mt-5 h-10">Publish</button>
          <button className="bg-[#C09934] mt-4 rounded-lg h-10">
            Save as Draft
          </button>
          <button className="bg-[#C03434] mt-4 rounded-lg h-10">Cancel</button>
        </div>
        <div className="w-1/2 h-80">
          <h2 className="text-3xl">Task content</h2>
          <textarea className="w-full h-full rounded-lg mt-2"></textarea>
        </div>
        <div className="w-1/4 h-96">
          <ListContainer
            headers={headers}
            data={[]}
            title="Correct answers"
            addNew={
              <div className="flex justify-center mt-5">
                <Link to="/courses/add/">+ Add new answer</Link>
              </div>
            }
          />
        </div>
      </div>
    </div>
  );
}
