const root = document.getElementById("root");
const { useState } = React;

const style = {
  display: "flex",
  flexDirection: "column",
  gap: "20px",
  paddingTop: "2rem",
};

const Form = () => {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [hidden, setHidden] = useState(true);

  return hidden ? (
    <div className="card cardForm">
      <header>
        <h1>Register</h1>
      </header>
      <form>
        <div style={style}>
          <input
            type="text"
            placeholder="Ingrese su nombre"
            onChange={(e) => setName(e.target.value)}
          />
          <input
            type="password"
            placeholder="Ingrese su contraseña"
            onChange={(e) => setPassword(e.target.value)}
            style={{
              color:
                password.length >= 8
                  ? "green"
                  : password.length === 0
                  ? "black"
                  : "red",
            }}
          />
          <button
            onClick={() => setHidden(!hidden)}
            disabled={name.length !== 0 && password.length >= 8 ? false : true}
          >
            Enviar
          </button>
        </div>
      </form>
    </div>
  ) : (
    <Saludo hidden={hidden} name={name} password={password} />
  );
};

const Saludo = ({ name, password, hidden }) => {
  return (
    !hidden && (
      <div className="card cardSaludo">
        <header>
          <h1>Bienvenido!</h1>
        </header>
        <div style={style}>
          <p>Nombre: {name}</p>
          <p>Contraseña: {password}</p>
          <button type="button" onClick={() => window.location.reload()}>
            Volver al inicio
          </button>
        </div>
      </div>
    )
  );
};

const App = () => {
  return (
    <div className="App">
      <Form />
    </div>
  );
};

ReactDOM.render(<App />, root);
