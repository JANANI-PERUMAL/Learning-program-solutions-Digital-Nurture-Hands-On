import { Route, Routes } from "react-router-dom";
import Signup from "./Signup";
import Login from "./Login";
import Welcome from "./Welcome";

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Signup />} />
        <Route path="/login" element={<Login />} />
      <Route path="/welcome" element={<Welcome />} />
      </Routes>
    </>
  );
};

export default App;
