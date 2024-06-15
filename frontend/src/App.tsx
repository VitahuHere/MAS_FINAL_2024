import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen.tsx";
import CourseManageScreen from "./components/screens/CourseManageScreen.tsx";
import TaskManagementScreen from "./components/screens/TaskManagementScreen.tsx";
import AddTaskScreen from "./components/screens/AddTaskScreen.tsx";
import CourseDetailsScreen from "./components/screens/CourseDetailsScreen.tsx";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeScreen />} />
        <Route path="/courses/manage/" element={<CourseManageScreen />} />
        <Route path="/courses/tasks/" element={<TaskManagementScreen />} />
        <Route path="/courses/tasks/add/" element={<AddTaskScreen />} />
        <Route path="/courses/1/" element={<CourseDetailsScreen />} />
      </Routes>
    </BrowserRouter>
  );
}
