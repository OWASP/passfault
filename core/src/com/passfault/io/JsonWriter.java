/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault.io;

import java.io.IOException;
import java.util.List;

import com.passfault.PasswordPattern;
import com.passfault.PathCost;
import com.passfault.TimeToCrack;
import java.io.Writer;

public class JsonWriter {

	public void write(Writer writer, PathCost highestPath) throws IOException {
		double cost = highestPath.getTotalCost();
		List<PasswordPattern> path = highestPath.getPath();
		writer.write('{');
			writer.write("\"cost\": "); 
			writer.write(Double.toString(cost)); 
			writer.write(',');
			
			writer.write("\"patterns\": [");
				for(int i=0,length=path.size(); i<length;i++){
					write(writer, path.get(i));
					if(i+1<length){
						writer.write(',');
					}
				}
			writer.write(']');
		writer.write('}');
		writer.flush();
	}

	public void write(Writer writer, PasswordPattern pattern) throws IOException {
		writer.write('{');
		
		writer.write("\"name\" : \"");
		writer.write(pattern.getName());
		writer.write("\",");
		
		writer.write("\"description\" : \"");
		writer.write(pattern.getDescription());
		writer.write("\",");
		
		writer.write("\"patternSize\" : ");
		writer.write(Double.toString(pattern.getPatternSize()));
        writer.write(",");

        writer.write("\"classification\" : \"");
        if (pattern.getClassification()!=null){
          writer.write(pattern.getClassification());
        }
		writer.write("\",");
		
		writer.write("\"matchString\" : \"");
		CharSequence matchString = pattern.getMatchString();
		for(int i=0; i<matchString.length(); i++){
			writer.write(matchString.charAt(i));
		}
		writer.write("\",");
		
		writer.write("\"startIndex\" : ");
		writer.write(Integer.toString(pattern.getStartIndex()));
		writer.write(",");
		
		writer.write("\"length\" : ");
		writer.write(Integer.toString(pattern.getLength()));
		
		writer.write('}');
	}
}
