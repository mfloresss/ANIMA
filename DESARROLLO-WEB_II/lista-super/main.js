const root = document.getElementById("root");
const { useState } = React;

const ListItem = ({ item, k, ...rest }) => {
  const [toDoDone, setToDoDone] = useState(false);

  return (
    <div
      style={{
        width: " 100%",
        padding: "5px 20px",
        display: "flex",
        alignItems: " center",
        justifyContent: "space-between",
        background: item.type === "fruta" ? "#4DCCBD" : "#2374AB",
        borderRadius: "20px",
      }}
    >
      <li
        key={k}
        style={{
          color: "#fff",
          textDecoration: toDoDone ? "line-through" : "none",
        }}
      >
        {item.data.toLocaleUpperCase()}
      </li>
      <input
        style={{
          width: "1rem",
          height: "1rem",
        }}
        type="checkbox"
        value={item.data}
        onClick={(e) => {
          if (item.data === e.target.value) setToDoDone(!toDoDone);
        }}
      />
    </div>
  );
};

const List = () => {
  const list = [
    {
      type: "fruta",
      data: "naranja",
    },
    {
      type: "fruta",
      data: "manzana",
    },
    {
      type: "alimento",
      data: "cereal",
    },
    {
      type: "alimento",
      data: "pan",
    },
  ];

  return (
    <div className="listCard">
      <h1 style={{ color: "#231651" }}>Lista super</h1>
      <div
        style={{
          width: "100%",
          height: "calc(100% - 87.5px)",
          padding: "0 20px",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "center",
          gap: "40px",
          overflowY: "auto",
        }}
      >
        {list.map((item, i) => (
          <ListItem item={item} key={i} />
        ))}
      </div>
    </div>
  );
};

// value={item.data}
// onClick={(e) => {
//   if (item.data === e.target.value) {
//     item.complete = !item.complete;
//   }
// }}

const App = () => {
  return (
    <div className="App">
      <List />
    </div>
  );
};

ReactDOM.render(<App />, root);
