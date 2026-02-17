import { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import api from "../../api/axios";
import Navbar from "../../components/Navbar";

function UpdateStatusPage() {
  const { orderId } = useParams();
  const navigate = useNavigate();

  const [status, setStatus] = useState("RECEIVED");

  const updateStatus = async () => {
    await api.put(`/api/user/orders/vendor/${orderId}/status`, { status });

    alert("Status updated");
    navigate("/vendor/orders");
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Update Status"
        onLogout={() => navigate("/vendor-login")}
      />

      <div className="max-w-md mx-auto bg-white p-8 rounded shadow mt-8">
        <h2 className="text-lg font-bold mb-4">Update Order Status</h2>

        <div className="space-y-2 mb-4">
          {["RECEIVED", "READY_FOR_SHIPPING", "OUT_FOR_DELIVERY"].map((s) => (
            <label key={s} className="block">
              <input
                type="radio"
                name="status"
                value={s}
                checked={status === s}
                onChange={() => setStatus(s)}
                className="mr-2"
              />
              {s}
            </label>
          ))}
        </div>

        <button
          onClick={updateStatus}
          className="bg-green-600 text-white px-4 py-2 rounded w-full"
        >
          Update
        </button>
      </div>
    </div>
  );
}

export default UpdateStatusPage;
