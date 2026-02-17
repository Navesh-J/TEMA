import { useLocation, useNavigate } from "react-router-dom";

function OrderSuccessPage() {
  const { state } = useLocation();
  const navigate = useNavigate();

  if (!state) return <p>No order found</p>;

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-8 rounded shadow w-125">
        <h2 className="text-xl font-bold mb-2">PopUp</h2>

        <h3 className="text-green-600 text-lg font-semibold mb-4">THANK YOU</h3>

        <p className="mb-4 font-semibold">
          Total Amount: Rs {state.totalAmount}
        </p>

        <div className="space-y-1 text-sm mb-4">
          <p>Name: {state.name}</p>
          <p>Email: {state.email}</p>
          <p>Address: {state.address}</p>
          <p>City: {state.city}</p>
          <p>Number: {state.phone}</p>
          <p>Payment: {state.paymentMethod}</p>
          <p>State: {state.state}</p>
          <p>Pin Code: {state.pinCode}</p>
        </div>

        <button
          onClick={() => navigate("/user-dashboard")}
          className="w-full bg-blue-600 text-white py-2 rounded"
        >
          Continue Shopping
        </button>
      </div>
    </div>
  );
}

export default OrderSuccessPage;
