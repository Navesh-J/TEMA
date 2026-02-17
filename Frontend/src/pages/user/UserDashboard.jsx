import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import { AuthContext } from "../../context/AuthContext";

function UserDashboard() {
  const navigate = useNavigate();
  const { logout } = useContext(AuthContext);

  const [category, setCategory] = useState("CATERING");

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="WELCOME USER"
        onLogout={() => {
          logout();
          navigate("/user-login");
        }}
      />

      <div className="max-w-4xl mx-auto bg-white p-8 rounded shadow">
        <div className="mb-6">
          <label className="block mb-2 font-medium">Category Filter</label>
          <select
            className="border p-2 w-full"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          >
            <option>CATERING</option>
            <option>FLORIST</option>
            <option>DECORATION</option>
            <option>LIGHTING</option>
          </select>
        </div>

        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          <button
            onClick={() => navigate(`/user/vendors/${category}`)}
            className="bg-blue-600 text-white p-4 rounded"
          >
            Vendor
          </button>

          <button
            onClick={() => navigate("/user/cart")}
            className="bg-green-600 text-white p-4 rounded"
          >
            Cart
          </button>

          <button
            onClick={() => navigate("/user/guests")}
            className="bg-purple-600 text-white p-4 rounded"
          >
            Guest List
          </button>

          <button
            onClick={() => navigate("/user/orders")}
            className="bg-orange-600 text-white p-4 rounded"
          >
            Order Status
          </button>
        </div>
      </div>
    </div>
  );
}

export default UserDashboard;
