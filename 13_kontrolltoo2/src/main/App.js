import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [matkajad, setMatkajad] = useState([]);
  const [uusMatkaja, setUusMatkaja] = useState({
    nimi: '',
    kilomeetraaz: 0,
    riikideArv: 0
  });

  useEffect(() => {
    saaKoikMatkajad();
  }, []);

  const saaKoikMatkajad = () => {
    axios.get('/matkajad')
      .then(response => {
        setMatkajad(response.data);
      })
      .catch(error => {
        console.error('Viga matkajate saamisel:', error);
      });
  };

  const lisaMatkaja = () => {
    axios.post('/matkajad', uusMatkaja)
      .then(response => {
        setUusMatkaja({
          nimi: '',
          kilomeetraaz: 0,
          riikideArv: 0
        });
        saaKoikMatkajad();
      })
      .catch(error => {
        console.error('Viga matkaja lisamisel:', error);
      });
  };

  const kustutaMatkaja = (id) => {
    axios.delete(`/matkajad/${id}`)
      .then(response => {
        saaKoikMatkajad();
      })
      .catch(error => {
        console.error('Viga matkaja kustutamisel:', error);
      });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUusMatkaja(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  return (
    <div>
      <h1>Matkajad</h1>
      <ul>
        {matkajad.map(matkaja => (
          <li key={matkaja.id}>
            {matkaja.nimi} - {matkaja.kilomeetraaz} km - {matkaja.riikideArv} riiki
            <button onClick={() => kustutaMatkaja(matkaja.id)}>Kustuta</button>
          </li>
        ))}
      </ul>
      <h2>Lisa uus matkaja</h2>
      <input type="text" name="nimi" value={uusMatkaja.nimi} onChange={handleChange} placeholder="Nimi" />
      <input type="number" name="kilomeetraaz" value={uusMatkaja.kilomeetraaz} onChange={handleChange} placeholder="Kilomeetraaž" />
      <input type="number" name="riikideArv" value={uusMatkaja.riikideArv} onChange={handleChange} placeholder="Riikide arv" />
      <button onClick={lisaMatkaja}>Lisa</button>
    </div>
  );
}

export default App;
