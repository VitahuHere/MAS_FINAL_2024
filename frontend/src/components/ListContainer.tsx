import DataTable from "./DataTable.tsx";

export default function ListContainer({
  title,
  headers,
  data,
  addNew,
  redirectPaths,
}: {
  title: string;
  headers: any[];
  data: any[];
  addNew?: any;
  redirectPaths?: string[];
}) {
  return (
    <div className="flex items-center justify-center h-full">
      <div className="border-2 border-white rounded-lg px-6 py-11 w-full h-full">
        <h2 className="text-3xl mb-9">{title}</h2>
        <DataTable
          headers={headers}
          data={data}
          redirectPaths={redirectPaths}
        />
        {addNew}
      </div>
    </div>
  );
}
