import { useEffect, useRef, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import ListContainer from "../ListContainer.tsx";
import { publishTask } from "../../services/TaskService.ts";
import { fetchCourseDetails } from "../../services/CourseService.ts";

const headers = [
  { name: "No.", align: "left", width: "5%" },
  { name: "Answer", align: "center", width: "auto" },
];

export default function AddTaskScreen() {
  const navigate = useNavigate();
  const [title, setTitle] = useState("Task title");
  const [content, setContent] = useState("");
  const [isEditing, setIsEditing] = useState(false);
  const inputRef = useRef<HTMLInputElement>(null);

  const [contentTooLong, setContentTooLong] = useState(false);
  const [titleTooLong, setTitleTooLong] = useState(false);
  const [longTitle, setLongTitle] = useState(false);

  const params = useParams();
  const id = parseInt(params.id as string);

  function handleTitleChange(event: any) {
    if (event.target.value.length > 30) {
      setLongTitle(true);
    } else {
      setLongTitle(false);
    }
    if (event.target.value.length > 1024) {
      setTitleTooLong(true);
    } else {
      setTitleTooLong(false);
    }
    setTitle(event.target.value);
  }

  const defaultContentStyle =
    "w-full h-full rounded-lg mt-2 text-black px-5 py-5";
  const tooLongContent =
    "w-full h-full rounded-lg mt-2 text-black px-5 py-5 border-red-700 border-4";

  const defaultTitleStyle = "text-6xl";
  const longerTitle = "text-base";

  function handleContentChange(event: any) {
    if (event.target.value.length > 10000) {
      setContentTooLong(true);
    } else {
      setContentTooLong(false);
    }
    setContent(event.target.value);
  }

  function handleEdit() {
    setIsEditing(true);
    setTimeout(() => {
      if (inputRef.current) {
        inputRef.current.focus();
      }
    }, 0);
  }

  function handlePublish() {
    if (contentTooLong || titleTooLong) {
      return;
    }
    publishTask(id, {
      title: title,
      content: content,
      status: "PUBLISHED",
    }).then(() => {
      return navigate("/courses/" + id);
    });
  }

  function handleSaveAsDraft() {
    if (contentTooLong || titleTooLong) {
      return;
    }
    publishTask(id, {
      title: title,
      content: content,
      status: "DRAFT",
    }).then(() => {
      return navigate("/courses/" + id);
    });
  }

  function handleCancel() {
    navigate("/courses/" + id);
  }

  useEffect(() => {
    fetchCourseDetails(id).then((data) => {
      if (!data) {
        return navigate("/course-not-found");
      }
    });
  }, []);

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
        <div className="flex flex-row items-center z-10">
          <Link to={"/"}>
            <img
              src="/rubber-duck.png"
              alt="Rubber Duck"
              className="w-[178px]"
            />
          </Link>
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
            <h1 className={longTitle ? longerTitle : defaultTitleStyle}>
              {title}
            </h1>
          )}
          {titleTooLong && (
            <p className="text-red-600 text-3xl">
              The title is too long. Please shorten it.
            </p>
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
          <button
            className="bg-[#C09934] rounded-lg mt-5 h-10"
            onClick={handlePublish}
          >
            Publish
          </button>
          <button
            className="bg-[#C09934] mt-4 rounded-lg h-10"
            onClick={handleSaveAsDraft}
          >
            Save as Draft
          </button>
          <button
            className="bg-[#C03434] mt-4 rounded-lg h-10"
            onClick={handleCancel}
          >
            Cancel
          </button>
        </div>
        <div className="w-1/2 h-80">
          <h2 className="text-3xl">Task content</h2>
          <textarea
            className={contentTooLong ? tooLongContent : defaultContentStyle}
            onChange={handleContentChange}
          ></textarea>
          {contentTooLong && (
            <p className="text-red-600 text-3xl">
              The content is too long. Please shorten it.
            </p>
          )}
        </div>
        <div className="w-1/4 h-96">
          <ListContainer
            headers={headers}
            data={[]}
            title="Correct answers"
            addNew={
              <div className="flex justify-center mt-5">
                <Link to="/notimplemented">+ Add new answer</Link>
              </div>
            }
          />
        </div>
      </div>
    </div>
  );
}
