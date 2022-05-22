// ---------------------------------------------
// CLASS 11 DE MAYO
// ---------------------------------------------

const root = document.getElementById("root");
const name = "Michael";
const lastName = "Flores";

const element = (
  <p>
    Hola, soy {name} {lastName}
    {/* Hola, soy {name} {lastName} */}
  </p>
);

const element2 = React.createElement(
  "p",
  {
    children: "Hola, soy",
  },
  name,
  lastName
);

const element3 = React.createElement(React.Fragment, null, name, lastName);

const element4 = <>{[name, " ", lastName]}</>;

const Mensaje = (props) => (
  <div style={{ color: props.color }}>
    <h1>{props.title}</h1>
    <p>{props.text}</p>
  </div>
);

// Mensaje.propTypes = {
//   title: propTypes.string.isRequired,
//   text: propTypes.string.isRequired,
// };

const element5 = (
  <>
    {/* {mensaje({
      title: "Usando el componente primera vez",
      msg: "Que onda pa",
      bg: "red",
    })}
    {mensaje({
      title: "Usando el componente segunda vez vez",
      msg: "Que onda pa",
    })} */}
    <Mensaje title="Mensaje 1" text="Que onda pa" color="red" />
    <Mensaje title="Mensaje 2" text="Que onda pa" color="blue" />
  </>
);

ReactDOM.render(element5, root);

// ReactDOM.render(<p>Hola, soy {name} {lastName}</p>, root);
// ReactDOM.render(<p>Hola, soy {[name, " ", lastName]}</p>, root);
