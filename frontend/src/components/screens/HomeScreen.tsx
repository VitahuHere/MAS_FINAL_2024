import Shortcuts from "../Shortcuts.tsx";

export default function HomeScreen() {
  return (
    <>
      <div>
        <img
          src="/rubber-duck.png"
          alt="Rubber Duck"
          className="absolute w-[178px]"
        />
        <div className="flex justify-center items-start h-full w-full pt-[25px]">
          <h1 className="text-8xl">EduKaczka</h1>
        </div>
      </div>
      <div className="flex flex-row">
        <Shortcuts />
        <div className="flex flex-grow justify-center items-end italic font-light text-[#F2D057] text-6xl">
          <h1>Learning is quacking fun!</h1>
        </div>
      </div>
    </>
  );
}
