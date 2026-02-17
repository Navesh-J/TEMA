import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";
import AuthCard from "../../components/AuthCard";

function UserSignup() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    fullName: "",
    email: "",
    password: "",
  });

  const handleSignup = async () => {
    try {
      await api.post("/api/auth/user/signup", form);

      alert("Signup successful");
      navigate("/user-login");
    } catch (err) {
      alert(err.response?.data?.message || "Error");
    }
  };

  return (
    <AuthCard title="Event Management System">
      <div className="flex justify-between mb-4">
        <button className="text-blue-600 text-sm">Chart</button>
        <button className="text-blue-600 text-sm" onClick={() => navigate("/")}>
          Back
        </button>
      </div>

      <input
        placeholder="Name"
        className="w-full border p-2 mb-3"
        onChange={(e) => setForm({ ...form, fullName: e.target.value })}
      />

      <input
        placeholder="Email"
        className="w-full border p-2 mb-3"
        onChange={(e) => setForm({ ...form, email: e.target.value })}
      />

      <input
        type="password"
        placeholder="Password"
        className="w-full border p-2 mb-4"
        onChange={(e) => setForm({ ...form, password: e.target.value })}
      />

      <button
        onClick={handleSignup}
        className="w-full bg-green-600 text-white p-2 rounded"
      >
        Sign Up
      </button>
    </AuthCard>
  );
}

export default UserSignup;
