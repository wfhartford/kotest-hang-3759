package ca.cutterslade.kotesthang

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration

class KotestHangSpec : FunSpec(
  {
    lateinit var job: Job
    beforeSpec {
      println("Starting background job")
      val parentJob = checkNotNull(Job(currentCoroutineContext()[Job])) { "No parent job" }
      job = GlobalScope.launch(parentJob) { delay(Duration.INFINITE) }
    }

    afterSpec {
      println("Cancelling background job")
      job.cancel()
    }

    afterTest { (case, result) ->
      println("Test '${case.name.testName}' $result")
    }

    test("always pass") {
      println("Executing test")
    }
  }
)
