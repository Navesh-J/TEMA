import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import { AuthContext } from "../../context/AuthContext";

function VendorDashboard() {
  const navigate = useNavigate();
  const { logout } = useContext(AuthContext);

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Welcome Vendor"
        onLogout={() => {
          logout();
          navigate("/vendor-login");
        }}
      />

      <div className="max-w-4xl mx-auto bg-white p-8 rounded shadow">
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          <button
            onClick={() => navigate("/vendor/products")}
            className="bg-blue-500 text-white p-4 rounded"
          >
            Your Item
          </button>

          <button
            onClick={() => navigate("/vendor/add-item")}
            className="bg-green-500 text-white p-4 rounded"
          >
            Add New Item
          </button>

          <button
            onClick={() => navigate("/vendor/transactions")}
            className="bg-purple-500 text-white p-4 rounded"
          >
            Transaction
          </button>

          <button
            onClick={() => navigate("/vendor/orders")}
            className="bg-orange-500 text-white p-4 rounded"
          >
            Product Status
          </button>
        </div>
      </div>
    </div>
  );
}

export default VendorDashboard;
