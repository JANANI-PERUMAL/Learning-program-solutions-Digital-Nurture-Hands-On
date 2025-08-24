import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [fname, setfname] = useState("");
  const [email, setemail] = useState("");
  const [phoneno, setphoneno] = useState("");
  const [password, setpassword] = useState("");
  const nav = useNavigate();

  const handleSignup = (e) => {
    e.preventDefault();

    if (!fname || !email || !phoneno || !password) {
      alert("Please fill in all fields.");
      return;
    }

    const user = {
      fname,
      email,
      phoneno,
      password,
    };

    // ✅ Save user data to localStorage
    window.localStorage.setItem("user", JSON.stringify(user));

    alert("Signup successful! Please login.");
    nav("/login");
  };

  return (
    <>
      <h1>SIGN UP</h1>
      <div className="container mt-3">
        <form onSubmit={handleSignup}>
          <div className="form-floating mb-3 mt-3">
            <input
              type="text"
              className="form-control"
              placeholder="Enter name"
              value={fname}
              onChange={(e) => setfname(e.target.value)}
            />
            <label>Name</label>
          </div>

          <div className="form-floating mb-3 mt-3">
            <input
              type="email"
              className="form-control"
              placeholder="Enter email"
              value={email}
              onChange={(e) => setemail(e.target.value)}
            />
            <label>Email</label>
          </div>

          <div className="form-floating mb-3 mt-3">
            <input
              type="text"
              className="form-control"
              placeholder="Enter phone number"
              value={phoneno}
              onChange={(e) => setphoneno(e.target.value)}
            />
            <label>Phone number</label>
          </div>

          <div className="form-floating mt-3 mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Enter password"
              value={password}
              onChange={(e) => setpassword(e.target.value)}
            />
            <label>Password</label>
          </div>

          <button type="submit" className="btn btn-primary">
            SIGN UP
          </button>
        </form>
      </div>
    </>
  );
};

export default Signup;
