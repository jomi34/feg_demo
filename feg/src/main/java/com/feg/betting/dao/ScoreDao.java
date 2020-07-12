/**
 * 
 */
package com.feg.betting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feg.betting.model.Score;

/**
 * @author kalebmij
 *
 */
@Repository
public interface ScoreDao extends JpaRepository<Score, Long>{

}
