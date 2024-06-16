export default function MessageScreen({ message }: { message: string }) {
  return (
    <div className="flex flex-col items-center justify-center h-full w-full">
      <h1 className="text-7xl">{message}</h1>
      <img
        src="/rubber-duck.png"
        alt="Rubber duck"
        className="w-1/4 mt-10 animate-spin-slow"
      />
    </div>
  );
}
