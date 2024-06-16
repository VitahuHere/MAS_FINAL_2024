import axios from "axios";
import { CourseDetails, CourseDTO } from "../types/CourseType.ts";
import { paths } from "./paths.ts";

async function fetchCourses(): Promise<CourseDTO[]> {
  const response = await axios.get(paths.courses);
  return response.data;
}

async function fetchCourseDetails(id: number): Promise<CourseDetails> {
  const response = await axios.get(paths.courseDetails(id));
  return response.data;
}

export { fetchCourses, fetchCourseDetails };
