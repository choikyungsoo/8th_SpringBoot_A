package umc.spring.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer reward;

  private LocalDate deadline;

  @Column(columnDefinition = "TEXT")
  private String missionSpec;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
  private List<MemberMission> memberMissionList = new ArrayList<>();

  @Override
  public String toString() {
    return "Mission{" +
        "id=" + id +
        ", reward=" + reward +
        ", deadline=" + deadline +
        ", missionSpec='" + missionSpec + '\'' +
        '}';
  }
}
