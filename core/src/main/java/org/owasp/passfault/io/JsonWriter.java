/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.owasp.passfault.io;

import java.io.IOException;
import java.util.List;

import java.io.Writer;

import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.api.AnalysisResult;

public class JsonWriter {

	public void write(Writer writer, AnalysisResult highestPath) throws IOException {
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
