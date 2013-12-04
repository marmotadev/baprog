/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ba;

/**
 *
 * @author tlapinskas
 */
public interface IShootingStrategy {

    String NONE = "NONE";

	public String shoot( HitStatus lastHit);
    
}
