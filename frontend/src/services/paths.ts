const root = "http://localhost:8080/api";
const paths = {
  courses: `${root}/courses`,
  coursesTasks: (id: number) => `${root}/courses/${id}/tasks`,
  courseDetails: (id: number) => `${root}/courses/${id}`,
  publishTask: (id: number) => `${root}/courses/${id}/tasks/add`,
};

export { paths };
