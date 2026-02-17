import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function CheckoutPage() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    email: "",
    address: "",
    city: "",
    state: "",
    pinCode: "",
    phone: "",
    paymentMethod: "CASH",
  });

  const placeOrder = async () => {
    try {
      const res = await api.post("/api/user/orders/checkout", form);

      navigate("/user/order-success", {
        state: res.data.data,
      });
    } catch (err) {
      alert(err.response?.data?.message || "Checkout failed");
    }
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-4xl mx-auto bg-white p-8 rounded shadow mt-6">
        <UserMenu />

        <h2 className="text-xl font-bold mb-6">Checkout Details</h2>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <input
            placeholder="Name"
            className="border p-2"
            onChange={(e) => setForm({ ...form, name: e.target.value })}
          />

          <input
            placeholder="E-mail"
            className="border p-2"
            onChange={(e) => setForm({ ...form, email: e.target.value })}
          />

          <input
            placeholder="Address"
            className="border p-2"
            onChange={(e) => setForm({ ...form, address: e.target.value })}
          />

          <input
            placeholder="City"
            className="border p-2"
            onChange={(e) => setForm({ ...form, city: e.target.value })}
          />

          <input
            placeholder="Number"
            className="border p-2"
            onChange={(e) => setForm({ ...form, phone: e.target.value })}
          />

          <input
            placeholder="State"
            className="border p-2"
            onChange={(e) => setForm({ ...form, state: e.target.value })}
          />

          <input
            placeholder="Pin Code"
            className="border p-2"
            onChange={(e) => setForm({ ...form, pinCode: e.target.value })}
          />

          <select
            className="border p-2"
            onChange={(e) =>
              setForm({ ...form, paymentMethod: e.target.value })
            }
          >
            <option value="CASH">Cash</option>
            <option value="UPI">UPI</option>
          </select>
        </div>

        <button
          onClick={placeOrder}
          className="mt-6 bg-green-600 text-white px-6 py-2 rounded"
        >
          Order Now
        </button>
      </div>
    </div>
  );
}

export default CheckoutPage;
