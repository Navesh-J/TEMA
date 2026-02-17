import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";
import Navbar from "../../components/Navbar";

function VendorOrdersPage() {
  const navigate = useNavigate();
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    loadOrders();
  }, []);

  const loadOrders = async () => {
    const res = await api.get("/api/user/orders/vendor");
    setOrders(res.data.data);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Product Status"
        onLogout={() => navigate("/vendor-login")}
      />

      <div className="max-w-6xl mx-auto bg-white p-8 rounded shadow">
        <table className="w-full border">
          <thead>
            <tr className="bg-gray-200">
              <th>Name</th>
              <th>Email</th>
              <th>Address</th>
              <th>Status</th>
              <th>Update</th>
            </tr>
          </thead>

          <tbody>
            {orders.map((o) => (
              <tr key={o.id} className="border-t text-center">
                <td>{o.name}</td>
                <td>{o.email}</td>
                <td>{o.address}</td>
                <td>{o.status}</td>

                <td>
                  <button
                    onClick={() => navigate(`/vendor/update-status/${o.id}`)}
                    className="bg-blue-500 text-white px-3 py-1 rounded"
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default VendorOrdersPage;
