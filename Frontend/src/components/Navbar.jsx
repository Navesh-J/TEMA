function Navbar({ title, onLogout }) {
  return (
    <div className="flex justify-between items-center bg-white shadow px-6 py-4 mb-6">
      <h1 className="text-xl font-bold">{title}</h1>

      <button
        onClick={onLogout}
        className="bg-red-500 text-white px-4 py-2 rounded"
      >
        LogOut
      </button>
    </div>
  );
}

export default Navbar;
