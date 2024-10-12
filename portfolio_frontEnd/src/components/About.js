import React, { useEffect, useState } from 'react';
import axios from 'axios';

const About = () => {
  const [about, setAbout] = useState({});

  useEffect(() => {
    const fetchAbout = async () => {
      try {
        const response = await axios.get('http://localhost:8081/portfolio/about'); // Update API URL
        setAbout(response.data);
      } catch (error) {
        console.error('Error fetching about info:', error);
      }
    };

    fetchAbout();
  }, []);

  return (
    <section className="about">
      <h2>About Me</h2>
      {about.title ? ( 
        <>
          <h3>{about.title}</h3>
          <p>{about.description}</p>
          {about.imageUrl && (
            <img
              src={about.imageUrl}
              alt={about.title}
              style={{ width: '100%', borderRadius: '4px' }}
            />
          )}
        </>
      ) : (
        <p>No information available</p>
      )}
    </section>
  );
  
};

export default About;
