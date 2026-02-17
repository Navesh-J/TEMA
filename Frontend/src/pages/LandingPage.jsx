import { useNavigate } from "react-router-dom";

function LandingPage() {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center justify-center">
      {/* Header */}
      <div className="bg-white shadow rounded-lg p-10 w-105 text-center">
        <h1 className="text-3xl font-bold mb-2">Event Management System</h1>

        <p className="text-gray-600 mb-8">
          Technical Event Management Application
        </p>

        {/* Role Buttons */}
        <div className="space-y-3">
          <button
            onClick={() => navigate("/admin-login")}
            className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700"
          >
            Admin Login
          </button>

          <button
            onClick={() => navigate("/vendor-login")}
            className="w-full bg-green-600 text-white py-2 rounded hover:bg-green-700"
          >
            Vendor Login
          </button>

          <button
            onClick={() => navigate("/user-login")}
            className="w-full bg-purple-600 text-white py-2 rounded hover:bg-purple-700"
          >
            User Login
          </button>
        </div>

        {/* Signup Links */}
        <div className="mt-6 text-sm text-gray-600">
          <p>
            New User?{" "}
            <span
              className="text-blue-600 cursor-pointer"
              onClick={() => navigate("/user-signup")}
            >
              Sign Up
            </span>
          </p>

          <p className="mt-2">
            New Vendor?{" "}
            <span
              className="text-blue-600 cursor-pointer"
              onClick={() => navigate("/vendor-signup")}
            >
              Sign Up
            </span>
          </p>
        </div>
      </div>

      {/* Footer */}
      <p className="mt-6 text-sm text-gray-500">
        © Event Management System MVP
      </p>
    </div>
  );
}

export default LandingPage;
