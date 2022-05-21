const optionCountry = document.getElementById("options");
const selectCountry = document.getElementById("submit");

const getAPICountries = async () => {
  const response = await fetch("https://api.covid19api.com/summary");
  return (data = response.json());
};

const getCountries = async () => {
  const dataAPICountries = await getAPICountries();

  const getCountry = dataAPICountries.Countries.map((country) => {
    return `<option value=${country.ID}>${country.Country}</option>`;
  });

  const showInfoCountry = () => {
    const getCountry = dataAPICountries.Countries.find( Countries => Countries.ID === optionCountry.value );
    
    const flagCountry = getCountry.CountryCode;
    
    document.getElementById("showInfo").classList.add("showInfo");

    document.getElementById("showInfo").innerHTML = `
      <header>
        <h2>${getCountry.Country}</h2>
        <img src="https://flagcdn.com/56x42/${flagCountry.toLowerCase()}.png" alt="${getCountry.Country}">
      </header>
      <ul>
          <li>Nuevos casos confirmados: ${getCountry.NewConfirmed}</li>
          <li>Casos totales confirmados: ${getCountry.TotalConfirmed}</li>
          <li>Nuevas muertes: ${getCountry.NewDeaths}</li>
          <li>Muertes totales: ${getCountry.TotalDeaths}</li>
          <li>Nuevos casos recuperados: ${getCountry.NewRecovered}</li>
          <li>Casos totales recuperados: ${getCountry.TotalRecovered}</li>
      </ul>
      <a href="#container-showInfo" id="submit">Consultar otro pais</a>
    `;
  };

  optionCountry.innerHTML = getCountry;

  selectCountry.addEventListener("click", showInfoCountry);
};

getCountries();
