import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";
import { AuthContext } from "../../context/AuthContext";
import AuthCard from "../../components/AuthCard";

function AdminLogin() {
  const navigate = useNavigate();
  const { login } = useContext(AuthContext);

  const [form, setForm] = useState({
    email: "",
    password: "",
  });

  const handleLogin = async () => {
    try {
      const res = await api.post("/api/auth/login", {
        email: form.email,
        password: form.password,
        role: "ADMIN",
      });

      login(res.data.data.token);
      navigate("/admin-dashboard");
    } catch (err) {
      alert(err.response?.data?.message || "Login failed");
    }
  };

  return (
    <AuthCard title="Event Management System">
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

      <p className="text-sm mb-4">Role: ADMIN</p>

      <button
        onClick={handleLogin}
        className="w-full bg-blue-600 text-white p-2 mb-2 rounded"
      >
        Login
      </button>

      <button
        onClick={() => navigate("/")}
        className="w-full bg-gray-300 p-2 rounded"
      >
        Cancel
      </button>
    </AuthCard>
  );
}

export default AdminLogin;
