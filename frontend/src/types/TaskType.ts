type Task = {
  id: number;
  title: string;
  content: string;
  status: string;
};

type SaveTask = {
  title: string;
  content: string;
  status: string;
};

export type { Task, SaveTask };
