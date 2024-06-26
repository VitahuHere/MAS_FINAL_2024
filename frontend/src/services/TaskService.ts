import axios from "axios";
import { SaveTask } from "../types/TaskType.ts";
import { paths } from "./paths.ts";

export async function publishTask(courseId: number, task: SaveTask) {
  await axios.post(paths.publishTask(courseId), task);
}

export async function getTasks(courseId: number) {
  const response = await axios.get(paths.coursesTasks(courseId));
  return response.data;
}
