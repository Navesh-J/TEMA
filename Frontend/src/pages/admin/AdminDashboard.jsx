import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import { AuthContext } from "../../context/AuthContext";

function AdminDashboard() {
  const navigate = useNavigate();
  const { logout } = useContext(AuthContext);

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Welcome Admin"
        onLogout={() => {
          logout();
          navigate("/admin-login");
        }}
      />

      <div className="max-w-3xl mx-auto bg-white p-8 rounded shadow">
        <h2 className="text-lg font-semibold mb-6">Admin Dashboard</h2>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <button
            onClick={() => navigate("/admin-maintain-users")}
            className="bg-blue-600 text-white p-4 rounded"
          >
            Maintain User
          </button>

          <button
            onClick={() => navigate("/admin-maintain-vendors")}
            className="bg-green-600 text-white p-4 rounded"
          >
            Maintain Vendor
          </button>
        </div>
      </div>
    </div>
  );
}

export default AdminDashboard;
