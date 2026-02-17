import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function CartPage() {
  const navigate = useNavigate();
  const [items, setItems] = useState([]);

  const loadCart = async () => {
    const res = await api.get("/api/user/cart");
    setItems(res.data.data);
  };

  useEffect(() => {
    loadCart();
  }, []);

  const updateQty = async (id, qty) => {
    await api.put(`/api/user/cart/items/${id}`, {
      quantity: Number(qty),
    });
    loadCart();
  };

  const removeItem = async (id) => {
    await api.delete(`/api/user/cart/items/${id}`);
    loadCart();
  };

  const clearCart = async () => {
    await api.delete("/api/user/cart/clear");
    loadCart();
  };

  const grandTotal = items.reduce(
    (sum, i) => sum + i.priceAtTime * i.quantity,
    0,
  );

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-6xl mx-auto bg-white p-8 rounded shadow mt-6">
        <UserMenu />

        <h2 className="text-xl font-bold mb-6">Shopping Cart</h2>

        <div className="space-y-4">
          {items.map((item) => (
            <div
              key={item.id}
              className="grid grid-cols-6 gap-4 items-center border p-4 rounded"
            >
              <img
                src={item.product.imageUrl}
                alt=""
                className="h-16 w-16 object-cover"
              />

              <div>{item.product.name}</div>

              <div>Rs {item.priceAtTime}</div>

              <select
                value={item.quantity}
                onChange={(e) => updateQty(item.id, e.target.value)}
                className="border p-1"
              >
                {[1, 2, 3, 4, 5].map((n) => (
                  <option key={n}>{n}</option>
                ))}
              </select>

              <div>Rs {item.priceAtTime * item.quantity}</div>

              <button
                onClick={() => removeItem(item.id)}
                className="bg-red-500 text-white px-3 py-1 rounded"
              >
                Remove
              </button>
            </div>
          ))}
        </div>

        <div className="mt-6 border-t pt-4">
          <h3 className="text-lg font-semibold">
            Grand Total: Rs {grandTotal}
          </h3>

          <div className="flex gap-3 mt-4">
            <button
              onClick={clearCart}
              className="bg-gray-500 text-white px-4 py-2 rounded"
            >
              Delete All
            </button>

            <button
              onClick={() => navigate("/user/checkout")}
              className="bg-green-600 text-white px-4 py-2 rounded"
            >
              Proceed to Checkout
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CartPage;
