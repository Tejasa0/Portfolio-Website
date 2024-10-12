import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Skills = () => {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    const fetchSkills = async () => {
      try {
        const response = await axios.get('http://localhost:8081/portfolio/skills'); // Update API URL
        setSkills(response.data);
      } catch (error) {
        console.error('Error fetching skills:', error);
      }
    };

    fetchSkills();
  }, []);

  return (
    <section className="skills">
      <h2>Skills</h2>
      {skills.length > 0 ? (
        skills.map(skill => (
          <div key={skill.id} className="skill">
            <h3>{skill.name}</h3>
            <p>Proficiency: {skill.level}%</p>
          </div>
        ))
      ) : (
        <p>No skills available</p>
      )}
    </section>
  );
};

export default Skills;
