import { useNavigate } from "react-router-dom";

export default function Navbar({ title }: { title?: string }) {
  const navigate = useNavigate();

  return (
    <div className="relative flex items-center w-full">
      <div className="flex flex-row items-center">
        <img src="/rubber-duck.png" alt="Rubber Duck" className="w-[178px]" />
        <button onClick={() => navigate(-1)} className="w-24 h-24">
          <img src="/left-arrow.png" alt="Left Arrow" />
        </button>
      </div>
      <div className="absolute inset-0 flex justify-center items-center">
        <h1 className="text-8xl">{title}</h1>
      </div>
    </div>
  );
}
