import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const nav = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    const storedUser = JSON.parse(window.localStorage.getItem("user"));

    if (!storedUser) {
      setMessage("No user found. Please sign up first.");
      return;
    }

    if (name === storedUser.fname && password === storedUser.password) {
      setMessage("Login successful!");
      // ✅ Navigate to Welcome page
      setTimeout(() => {
        nav("/welcome");
      }, 1000); // 1 second delay so user sees the success message
    } else {
      setMessage("Invalid name or password.");
    }
  };

  return (
    <>
      <h1>Login Page</h1>
      <div className="container mt-3">
        <form onSubmit={handleLogin}>
          <div className="form-floating mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Enter Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            <label>Name</label>
          </div>

          <div className="form-floating mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Enter Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <label>Password</label>
          </div>

          <button type="submit" className="btn btn-success">
            Login
          </button>
        </form>

        {message && <div className="alert alert-info mt-3">{message}</div>}
      </div>
    </>
  );
};

export default Login;
