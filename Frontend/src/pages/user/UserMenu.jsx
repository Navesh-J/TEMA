import { useNavigate } from "react-router-dom";

function UserMenu() {
  const navigate = useNavigate();

  return (
    <div className="flex justify-between mb-6">
      <button
        onClick={() => navigate("/user-dashboard")}
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        Home
      </button>

      <button
        onClick={() => {
          localStorage.removeItem("token");
          navigate("/user-login");
        }}
        className="bg-red-500 text-white px-4 py-2 rounded"
      >
        LogOut
      </button>
    </div>
  );
}

export default UserMenu;
