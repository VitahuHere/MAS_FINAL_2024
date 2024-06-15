export default function CourseSettings() {
  return (
    <div className="flex flex-col w-80">
      <h2 className="text-4xl">Course settings</h2>
      <button className="bg-[#C09934] rounded-lg mt-5 h-10">
        Rename course
      </button>
      <button className="bg-[#C09934] mt-4 rounded-lg h-10">
        Change description
      </button>
      <button className="bg-[#C09934] mt-4 rounded-lg h-10">
        Change keywords
      </button>
    </div>
  );
}
