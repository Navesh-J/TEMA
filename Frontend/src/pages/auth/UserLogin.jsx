import { useState, useContext } from "react";
import api from "../../api/axios";
import { AuthContext } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";


function UserLogin() {
  const { login } = useContext(AuthContext);
  const navigate = useNavigate();

  const [form, setForm] = useState({
    email: "",
    password: "",
  });

  const handleSubmit = async () => {
    try {
      const res = await api.post("/api/auth/login", {
        email: form.email,
        password: form.password,
        role: "USER",
      });

      login(res.data.data.token);
      alert("Login Success");
      navigate("/user-dashboard")
    } catch (err) {
      alert(err.response?.data?.message || "Error");
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded shadow w-96">
        <h1 className="text-2xl font-bold text-center mb-6">
          Event Management System
        </h1>

        <input
          type="text"
          placeholder="User ID"
          className="w-full border p-2 mb-3"
          onChange={(e) => setForm({ ...form, email: e.target.value })}
        />

        <input
          type="password"
          placeholder="Password"
          className="w-full border p-2 mb-3"
          onChange={(e) => setForm({ ...form, password: e.target.value })}
        />

        <p className="text-sm mb-4">Role: USER</p>

        <button
          onClick={handleSubmit}
          className="w-full bg-blue-600 text-white p-2 mb-2 rounded"
        >
          Login
        </button>

        <button onClick={() => navigate("/")} className="w-full bg-gray-300 p-2 rounded">Cancel</button>
      </div>
    </div>
  );
}

export default UserLogin;
