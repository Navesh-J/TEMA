import { useEffect, useState } from "react";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function UserOrdersPage() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    loadOrders();
  }, []);

  const loadOrders = async () => {
    const res = await api.get("/api/user/orders");
    setOrders(res.data.data);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-5xl mx-auto bg-white p-8 mt-6 rounded shadow">
        <UserMenu />

        <h2 className="text-xl font-bold mb-4">User Order Status</h2>

        <table className="w-full border">
          <thead>
            <tr className="bg-gray-200">
              <th>Name</th>
              <th>Email</th>
              <th>Address</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((o) => (
              <tr key={o.id} className="text-center border-t">
                <td>{o.name}</td>
                <td>{o.email}</td>
                <td>{o.address}</td>
                <td>{o.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default UserOrdersPage;
