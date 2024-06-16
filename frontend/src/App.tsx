import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen.tsx";
import CourseManageScreen from "./components/screens/CourseManageScreen.tsx";
import TaskManagementScreen from "./components/screens/TaskManagementScreen.tsx";
import AddTaskScreen from "./components/screens/AddTaskScreen.tsx";
import CourseDetailsScreen from "./components/screens/CourseDetailsScreen.tsx";
import MessageScreen from "./components/screens/MessageScreen.tsx";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeScreen />} />
        <Route path="/courses/" element={<CourseManageScreen />} />
        <Route
          path="/courses-add-task/"
          element={<CourseManageScreen addTask={true} />}
        />
        <Route path="/courses/:id/tasks/add/" element={<AddTaskScreen />} />
        <Route path="/courses/:id/tasks/" element={<TaskManagementScreen />} />
        <Route path="/courses/:id/" element={<CourseDetailsScreen />} />
        <Route
          path="/notimplemented"
          element={
            <MessageScreen message={"Not implemented, mocks just for design"} />
          }
        />
        <Route
          path="/course-not-found"
          element={
            <MessageScreen message={"Course with given id doesn't exist"} />
          }
        />
        <Route path="*" element={<MessageScreen message={"404 Not Found"} />} />
      </Routes>
    </BrowserRouter>
  );
}
