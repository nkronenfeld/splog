/*
 * Copyright 2016 Uncharted Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package software.uncharted.splog

import org.apache.spark.SharedSparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.scalatest.FunSpec

class SparkSessionLoggerSpec extends FunSpec with SharedSparkContext with LoggingSparkSession {
  describe("splog.LoggingSparkSession") {
    it("Should be able to get a logger directly from a spark session using implicits") {
      // Hack used that we won't need anymore come spark 2.3
      val spark: SparkSession = new SQLContext(sc).sparkSession

      assert(spark.getLogger("abc").isInstanceOf[Logger])
    }
  }
}