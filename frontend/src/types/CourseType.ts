import { Student } from "./StudentType.ts";
import { Task } from "./TaskType.ts";
import { TutorialDTO } from "./TutorialType.ts";
import { Opinion } from "./OpinionType.ts";

type Course = {
  name: string;
  description: string;
  createdAt: string;
  updatedAt: string;
};

type CourseDTO = {
  id: number;
  name: string;
  description: string;
  createdAt: string;
  updatedAt: string;
};

type CourseDetails = {
  id: number;
  name: string;
  students: Student[];
  tutorials: TutorialDTO[];
  tasks: Task[];
  opinions: Opinion[];
};

export type { Course, CourseDTO, CourseDetails };
